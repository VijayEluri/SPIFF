/* Generated By:JJTree: Do not edit this line. ASTfixedNumber.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package com.revbingo.spiff.parser.gen;

public
class ASTfixedNumber extends SimpleNode {

  public String literal;
  
  public ASTfixedNumber(int id) {
    super(id);
  }

  public ASTfixedNumber(SpiffTreeParser p, int id) {
    super(p, id);
  }

  
  /** Accept the visitor. **/
  @Override
public java.util.List<com.revbingo.spiff.instructions.Instruction> jjtAccept(SpiffTreeParserVisitor visitor, java.util.List<com.revbingo.spiff.instructions.Instruction> data) {
    return visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=9b8a0c56e7083143106275deaa57796e (do not edit this line) */
