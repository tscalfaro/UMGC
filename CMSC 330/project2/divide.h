/*
 * divide.h
 *
 *  Created on: Apr 30, 2024
 *      Author: tscal
 */

#ifndef DIVIDE_H_
#define DIVIDE_H_

class Divide: public SubExpression{
public:
	Divide(Expression* left, Expression* right): SubExpression(left, right){
		}
		double evaluate() {
		       return left->evaluate() / right->evaluate();
		    }
};



#endif /* DIVIDE_H_ */
