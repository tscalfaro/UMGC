/*
 * minimum.h
 * Created by: Antonio Scalfaro
 * CMSC 330
 * 04/30/2024
 *
 * The Minimum class is a child class of the SubExpression class and so implements the evaluate() method.
 * It returns the minimum of the left and right expressions.
 */

#ifndef MINIMUM_H_
#define MINIMUM_H_

class Minimum: public SubExpression{
public:
	Minimum(Expression* left, Expression* right): SubExpression(left, right){
		}
		double evaluate() {
		       return (left->evaluate() < right->evaluate()) ? left->evaluate() : right->evaluate();
		    }
};



#endif /* MINIMUM_H_ */
