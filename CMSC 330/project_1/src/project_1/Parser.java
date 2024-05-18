/*
 * Edited by: Antonio Scalfaro
 * CMSC 330
 * Project 1
 * 
 * This class has been edited to provide parsing for additional productions. The additional productions are listed below
 * in the comment block that stated the original productions (starting line 46).
 * */

package project_1;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

// This class provides the skeleton parser for project 1

class Parser {
    private JFrame window;
    private Token token;
    private Lexer lexer;

    // Constructor to create new lexical analyzer from input file

    public Parser(File file) throws IOException {
        lexer = new Lexer(file);
    }

    // Parses the production
    // scene -> SCENE IDENTIFIER number_list images END '.'

    public Scene parseScene() throws LexicalError, SyntaxError, IOException {
        verifyNextToken(Token.SCENE);
        verifyNextToken(Token.IDENTIFIER);
        String window = lexer.getLexeme();
        int[] dimensions = getNumberList(2);
        Scene scene = new Scene(window, dimensions[0], dimensions[1]);
        parseImages(scene, lexer.getNextToken());
        verifyNextToken(Token.PERIOD);
        return scene;
    }

    // Parses the following productions

    // images -> image images | image
    // image -> right_triangle | rectangle | text | isosceles_triangle | parallelogram | regular_polygon
    // right_triangle -> RIGHT_TRIANGLE COLOR number_list AT number_list HEIGHT NUMBER WIDTH NUMBER ';'
    // rectangle -> RECTANGLE_ COLOR number_list AT number_list HEIGHT NUMBER WIDTH NUMBER ';'
    // text -> TEXT COLOR number_list AT number_list "" ';'
    // isosceles_triangle -> ISOSCELES_TRIANGLE COLOR number_list AT number_list HEIGHT NUMBER WIDTH NUMBER ';'
    // parallelogram -> PARALLELOGRAM COLOR number_list AT number_list number_list OFFSET NUMBER ';'
    // regular_polygon -> REGULAR_POLYGON COLOR number_list AT number_list SIDES NUMBER RADIUS NUMBER ';'

    private void parseImages(Scene scene, Token imageToken) throws LexicalError, SyntaxError, IOException {
        int height, width, offset, radius, sides;
        String text_;
        verifyNextToken(Token.COLOR);
        int[] colors = getNumberList(3);
        Color color = new Color(colors[0], colors[1], colors[2]);
        verifyNextToken(Token.AT);
        int[] location = getNumberList(2);
        Point point = new Point(location[0], location[1]);
        if (imageToken == Token.RIGHT_TRIANGLE) {
            verifyNextToken(Token.HEIGHT);
            verifyNextToken(Token.NUMBER);
            height = lexer.getNumber();
            verifyNextToken(Token.WIDTH);
            verifyNextToken(Token.NUMBER);
            width = lexer.getNumber();
            RightTriangle triangle = new RightTriangle(color, point, height, width);
            scene.addImage(triangle);
        } else if (imageToken == Token.RECTANGLE) {
            verifyNextToken(Token.HEIGHT);
            verifyNextToken(Token.NUMBER);
            height = lexer.getNumber();
            verifyNextToken(Token.WIDTH);
            verifyNextToken(Token.NUMBER);
            width = lexer.getNumber();
            Rectangle rectangle = new Rectangle(color, point, height, width);
            scene.addImage(rectangle);
        } else if (imageToken == Token.TEXT) {
        	verifyNextToken(Token.TEXT);
        	text_ = lexer.getStringLiteral();
        	Text text = new Text(color, point, text_);
        	scene.addImage(text);
        } else if (imageToken == Token.ISOSCELES_TRIANGLE) {
        	verifyNextToken(Token.HEIGHT);
        	verifyNextToken(Token.NUMBER);
        	height = lexer.getNumber();
        	verifyNextToken(Token.WIDTH);
        	verifyNextToken(Token.NUMBER);
        	width = lexer.getNumber();
        	IsoscelesTriangle isoTriangle = new IsoscelesTriangle(color, point, height, width);
        	scene.addImage(isoTriangle);
        } else if (imageToken == Token.PARALLELOGRAM) {
        	int[] newPointLocations = getNumberList(2);
        	Point point2 = new Point(newPointLocations[0], newPointLocations[1]);
        	verifyNextToken(Token.OFFSET);
        	verifyNextToken(Token.NUMBER);
        	offset = lexer.getNumber();
        	Parallelogram parallelogram = new Parallelogram(color, point, point2, offset);
        	scene.addImage(parallelogram);
        } else if (imageToken == Token.REGULAR_POLYGON) {
        	verifyNextToken(Token.SIDES);
        	verifyNextToken(Token.NUMBER);
        	sides = lexer.getNumber();
        	verifyNextToken(Token.RADIUS);
        	verifyNextToken(Token.NUMBER);
        	radius = lexer.getNumber();
        	RegularPolygon regPolygon = new RegularPolygon(color, sides, point, radius);
        	scene.addImage(regPolygon);
        } else {
             throw new SyntaxError(lexer.getLineNo(), "Unexpected image name " + imageToken);
        }
        verifyNextToken(Token.SEMICOLON);
        token = lexer.getNextToken();
        if (token != Token.END)
            parseImages(scene, token);
    }

    // Parses the following productions

    // number_list -> '(' numbers ')'
    // numbers -> NUMBER | NUMBER ',' numbers

    // Returns an array of the numbers in the number list

    private int[]  getNumberList(int count) throws LexicalError, SyntaxError, IOException {
        int[] list = new int[count];
        verifyNextToken(Token.LEFT_PAREN);
        for (int i = 0; i < count; i++) {
            verifyNextToken(Token.NUMBER);
            list[i] = lexer.getNumber();
            token = lexer.getNextToken();
            if (i < count - 1)
                verifyCurrentToken(Token.COMMA);
            else
                verifyCurrentToken(Token.RIGHT_PAREN);
        }
        return list;
    }

    // Returns a list of numbers

    private int[] getNumberList() throws LexicalError, SyntaxError, IOException {
        ArrayList<Integer> list = new ArrayList<Integer>();
        verifyNextToken(Token.LEFT_PAREN);
        do {
            verifyNextToken(Token.NUMBER);
            list.add((int) lexer.getNumber());
            token = lexer.getNextToken();
        }
        while (token == Token.COMMA);
        verifyCurrentToken(Token.RIGHT_PAREN);
        int[] values = new int[list.size()];
        for (int i = 0; i < values.length; i++)
            values[i] = list.get(i);
        return values;
    }

    // Verifies that the next token is the expected token

    private void verifyNextToken(Token expectedToken) throws LexicalError, SyntaxError, IOException {
        token = lexer.getNextToken();
        verifyCurrentToken(expectedToken);
    }

    // Verifies that the current token is the expected token

    private void verifyCurrentToken(Token expectedToken) throws SyntaxError {
        if (token != expectedToken)
            throw new SyntaxError(lexer.getLineNo(), "Expecting token " + expectedToken + " not " + token);
    }
}
