/*
 * quarternary.h
 * Created by: Antonio Scalfaro
 * CMSC 330
 * 04/30/2024
 *
 * The Quarternary class is a child of the SubExpression class and so implements the evaluate() method.
 * It returns the 1st values (middle) if the conditional value (left) is less than 0, returns the 2ndj
 * value (middleRight) if the conditional value is 0, and returns the 3rd value (right) if the conditional
 * value is greater than 0.
 */

#ifndef QUARTERNARY_H_
#define QUARTERNARY_H_

class Quarternary: public SubExpression {
public:
	Quarternary(Expression* left, Expression* middle, Expression* middleRight, Expression* right): SubExpression(left, right), middle(middle), middleRight(middleRight){

	}
	double evaluate(){
		return (left->evaluate() < 0) ? middle->evaluate() : ((left->evaluate() == 0) ? middleRight->evaluate() : right->evaluate());
	}

private:
	Expression* middle;
	Expression* middleRight;
};


#endif /* QUARTERNARY_H_ */
