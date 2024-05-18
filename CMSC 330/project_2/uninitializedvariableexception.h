/*
 * uninitializedvariableexception.h
 * Created by: Antonio Scalfaro
 * CMSC 330
 * 05/01/2024
 *
 * The UninitializedVariableException class is a child of the SymbolTableException that will produce
 * an exception message if a variable is not initialized.
 */

#ifndef UNINITIALIZEDVARIABLEEXCEPTION_H_
#define UNINITIALIZEDVARIABLEEXCEPTION_H_

#include <exception>
#include <string>
#include "symboltableexception.h"

class UninitializedVariableException : public SymbolTableException {
public:
    explicit UninitializedVariableException(const std::string& variable)
        : SymbolTableException("Variable '" + variable + "' is not initialized") {}
};


#endif /* UNINITIALIZEDVARIABLEEXCEPTION_H_ */
