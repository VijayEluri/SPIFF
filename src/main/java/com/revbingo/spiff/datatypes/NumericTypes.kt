package com.revbingo.spiff.datatypes

import com.revbingo.spiff.ExecutionException
import com.revbingo.spiff.evaluator.Evaluator
import java.nio.ByteBuffer

class FixedLengthNumberFactory {

    fun getInstruction(name: String, type: String): NumberType {
        when (type) {
            "int" -> return IntegerInstruction(name)
            "long" -> return LongInstruction(name)
            "float" -> return FloatInstruction(name)
            "short" -> return ShortInstruction(name)
            "double" -> return DoubleInstruction(name)
            "byte" -> return ByteInstruction(name)
            "ubyte" -> return UnsignedByteInstruction(name)
            "ushort" -> return UnsignedShortInstruction(name)
            else -> return UnsignedIntegerInstruction(name)
        }
    }
}

abstract class NumberType(name: String, val type: Class<out Number>,
                          val bufferFunc: (ByteBuffer) -> Number) : Datatype(name) {

    var literalExpr: String? = null

    override fun evaluate(buffer: ByteBuffer, evaluator: Evaluator): Any {
        val value = bufferFunc(buffer)
        if(literalExpr != null) {
            val expressionResult = evaluator.evaluate(literalExpr!!, type)
            if(value != expressionResult) throw ExecutionException("Value $value did not match expected value $literalExpr")
        }
        return value
    }
}

class ByteInstruction(name: String): NumberType(name, Byte::class.java, { it.get() })

class ShortInstruction(name: String): NumberType(name, Short::class.java, { it.short })

class IntegerInstruction(name: String): NumberType(name, Int::class.java, { it.int })

class LongInstruction(name: String): NumberType(name, Long::class.java, { it.long })

class DoubleInstruction(name: String): NumberType(name, Double::class.java, { it.double })

class FloatInstruction(name: String): NumberType(name, Float::class.java, { it.float })

/*
* Unsigned numbers are represented by widening to the next widest type i.e. unsigned bytes are shorts,
* unsigned shorts are ints, unsigned ints are longs, unsigned longs are not supported
* */
fun ByteArray.convertToUnsignedInts(): IntArray = this.map { byte -> byte.toInt() and 0xFF }.toIntArray()

class UnsignedByteInstruction(name: String): NumberType(name, Short::class.java, {
    val bytes = ByteArray(1)
    it.get(bytes)

    bytes.convertToUnsignedInts()[0].toShort()
})

class UnsignedIntegerInstruction(name: String): NumberType(name, Long::class.java, {
    val bytes = ByteArray(4)
    val signedInt = it.int

    bytes[0] = (signedInt shr 24).toByte()
    bytes[1] = (signedInt shr 16).toByte()
    bytes[2] = (signedInt shr 8).toByte()
    bytes[3] = signedInt.toByte()

    val ubytes = bytes.convertToUnsignedInts()

    ((ubytes[0] shl 24)
            or (ubytes[1] shl 16)
            or (ubytes[2] shl 8)
            or (ubytes[3])).toLong()
})


class UnsignedShortInstruction(name: String): NumberType(name, Int::class.java, {
    val bytesAsInts = IntArray(2)
    val signedShortAsInt = it.short.toInt()

    bytesAsInts[0] = (signedShortAsInt shr 8) and 0xFF
    bytesAsInts[1] = signedShortAsInt and 0xFF

    (bytesAsInts[0] shl 8) or bytesAsInts[1]
})