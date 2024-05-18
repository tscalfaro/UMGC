/*
 * average.h
 * Created by: Antonio Scalfaro
 * CMSC 330
 * 04/30/2024
 *
 * The Average class is a child of the SubExpression class and so implements the evaluate() method.
 * It returns the average of the left and right expressions.
 */

#ifndef AVERAGE_H_
#define AVERAGE_H_

class Average: public SubExpression {
public:
	Average(Expression* left, Expression* right): SubExpression(left, right){
		}
		double evaluate() {
		       return (left->evaluate() + right->evaluate()) / 2.0;
		    }
};



#endif /* AVERAGE_H_ */
