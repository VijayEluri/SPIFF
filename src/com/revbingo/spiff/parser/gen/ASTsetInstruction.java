/* Generated By:JJTree: Do not edit this line. ASTsetInstruction.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.revbingo.spiff.parser.gen;

public
class ASTsetInstruction extends SimpleNode {

	public String name;
  public ASTsetInstruction(int id) {
    super(id);
  }

  public ASTsetInstruction(SpiffTreeParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  @Override
public java.util.List<com.revbingo.spiff.instructions.Instruction> jjtAccept(SpiffTreeParserVisitor visitor, java.util.List<com.revbingo.spiff.instructions.Instruction> data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=401a8f2c4185464872481af339db4cff (do not edit this line) */
