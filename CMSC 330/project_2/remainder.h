/*
 * remainder.h
 * Created by: Antonio Scalfaro
 * CMSC 330
 * 05/01/2024
 *
 * The Remainder class is a child of SubExpression and so imlements the evaluate() method.
 * It returns the remainder of the left value divided by the right value.
 */

#ifndef REMAINDER_H_
#define REMAINDER_H_
#include <cmath>

class Remainder: public SubExpression {
public:
	Remainder(Expression* left, Expression* right) : SubExpression(left, right){

	}
	double evaluate(){
		return fmod(left->evaluate(), right->evaluate());
	}
};



#endif /* REMAINDER_H_ */
