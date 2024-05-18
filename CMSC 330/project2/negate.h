/*
 * Created by: Antonio Scalfaro
 * CMSC 330
 * Project 2
 * 04/30/2024
 *
 * The Negate class is a child of the SubExpression class and implements the evaluate() method. The '~' is a
 * postfix expression and so the right expression is replaced by nullptr. The left expression is evaluated and
 * multiplied by '-1' to flip its sign.
 */

#ifndef NEGATE_H_
#define NEGATE_H_

class Negate: public SubExpression{
public:
	Negate(Expression* left): SubExpression(left, nullptr){
	}
	double evaluate()override {
	       return left->evaluate() * -1;
	    }
};



#endif /* NEGATE_H_ */
