/* Generated By:JJTree: Do not edit this line. ASTincludeInstruction.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.revbingo.spiff.parser.gen;

public
class ASTincludeInstruction extends SimpleNode {
  public ASTincludeInstruction(int id) {
    super(id);
  }

  public ASTincludeInstruction(SpiffTreeParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public java.util.List<com.revbingo.spiff.instructions.Instruction> jjtAccept(SpiffTreeParserVisitor visitor, java.util.List<com.revbingo.spiff.instructions.Instruction> data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=7089897a6b0a06751bd14af227f9ac6b (do not edit this line) */
