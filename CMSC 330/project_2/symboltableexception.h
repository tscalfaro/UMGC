/*
 * symboltableexception.h
 * Created by: Antonio Scalfaro
 * CMSC 330
 * 05/01/2024
 *
 * The SymbolTableException class is used to display exception message for the symbol table variables
 * if a variable is not initialized or initialized twice
 */

#ifndef SYMBOLTABLEEXCEPTION_H_
#define SYMBOLTABLEEXCEPTION_H_

#include <exception>
#include <string>

class SymbolTableException : public std::exception {
public:
	explicit SymbolTableException(const std::string& message) : msg(message){}
	virtual const char* what() const noexcept override{
		return msg.c_str();
	}
private:
	std::string msg;
};

#endif /* SYMBOLTABLEEXCEPTION_H_ */
