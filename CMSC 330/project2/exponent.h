/*
 * exponent.h
 * Created by: Antonio Scalfaro
 * CMSC 330
 * 04/30/2024
 *
 * The Exponent class is the child of SubExpression and so implements the evaluate() method.
 * It utilizes the pow() method from the cmath library to raise the left expression to the
 * power of the right expression.
 */
#include <cmath>
#ifndef EXPONENT_H_
#define EXPONENT_H_

class Exponent: public SubExpression {
public:
	Exponent(Expression* left, Expression* right): SubExpression(left, right){
		}
		double evaluate() {
		       return pow(left->evaluate(), right->evaluate());
		    }
};



#endif /* EXPONENT_H_ */
