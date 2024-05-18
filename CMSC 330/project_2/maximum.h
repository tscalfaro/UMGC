/*
 * maximum.h
 * Created by: Antonio Scalfaro
 * CMSC 330
 * 04/30/2024
 *
 * The Maximum class is a child of the SubExpression class and so implements the evaluate() method.
 * It returns the greater of the two values from the left and right expressions.
 */

#ifndef MAXIMUM_H_
#define MAXIMUM_H_

class Maximum: public SubExpression{
public:
	Maximum(Expression* left, Expression* right): SubExpression(left, right){
		}
		double evaluate() {
		       return (left->evaluate() > right->evaluate()) ? left->evaluate() : right->evaluate();
		    }
};



#endif /* MAXIMUM_H_ */
