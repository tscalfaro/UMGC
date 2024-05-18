/*
 * duplicatevariableexception.h
 * Created by: Antonio Scalfaro
 * CMSC 330
 * 05/01/2024
 *
 * The DuplicateVariableException class is a child of the SymbolTableException class and will display
 * an exception message if a variable is initialized twice
 */

#ifndef DUPLICATEVARIABLEEXCEPTION_H_
#define DUPLICATEVARIABLEEXCEPTION_H_

#include <exception>
#include <string>
#include "symboltableexception.h"

class DuplicateVariableException : public SymbolTableException {
public:
    explicit DuplicateVariableException(const std::string& variable)
        : SymbolTableException("Variable '" + variable + "' is initialized twice") {}
};


#endif /* DUPLICATEVARIABLEEXCEPTION_H_ */
