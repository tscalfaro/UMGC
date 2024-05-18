/*
 * multiply.h
 *
 *  Created on: Apr 30, 2024
 *      Author: tscal
 */
#ifndef MULTIPLY_H
#define MULTIPLY_H


class Multiply: public SubExpression{
public:
	Multiply(Expression* left, Expression* right): SubExpression(left, right){
	}
	double evaluate() {
	       return left->evaluate() * right->evaluate();
	    }
};
#endif // MULTIPLY_H