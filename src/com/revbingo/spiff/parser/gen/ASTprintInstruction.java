/* Generated By:JJTree: Do not edit this line. ASTprintInstruction.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.revbingo.spiff.parser.gen;

public
class ASTprintInstruction extends SimpleNode {
  public ASTprintInstruction(int id) {
    super(id);
  }

  public ASTprintInstruction(SpiffTreeParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public java.util.List<com.revbingo.spiff.instructions.Instruction> jjtAccept(SpiffTreeParserVisitor visitor, java.util.List<com.revbingo.spiff.instructions.Instruction> data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=d6f02d7722f5d768d1b5b87200202c28 (do not edit this line) */
