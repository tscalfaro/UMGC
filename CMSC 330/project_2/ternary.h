/*
 * ternary.h
 * Created by: Antonio Scalfaro
 * CMSC 330
 * 04/30/2024
 *
 * The Ternary class is a child of the SubExpression class and so implements the evaluate() method.
 * It returns the 1st value (middle) if the conditional value (left) is not equal to zero, and the
 * 2nd value (right) otherwise.
 */

#ifndef TERNARY_H_
#define TERNARY_H_

class Ternary: public SubExpression {
public:
	Ternary(Expression* left, Expression* middle, Expression* right): SubExpression(left, right), middle(middle){
		}
		double evaluate(){
			return (left->evaluate() != 0) ? middle->evaluate() : right->evaluate();
		}
private:
		Expression* middle;
};

#endif /* TERNARY_H_ */
