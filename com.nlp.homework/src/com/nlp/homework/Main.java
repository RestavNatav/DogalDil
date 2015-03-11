package com.nlp.homework;


public class Main {

	public static void main(String[] args) {
		
		HtmlParser Parser = new HtmlParser();
		
		Parser.getHtmlSource("Q:\\Users\\m_balci4\\My Documents\\ttt.html");
		
		String html = Parser.getSource();
		
		Regex rgx = new Regex();
		
		rgx.SetHTML(html);
		
		rgx.printInfo();
	}

}
