package org.hbrs.se1.ws24.exercises.uebung9;

public class TextDocument extends AbstractCoreDocument {
    private String content;
    private Encoding coding;
    public TextDocument(String content, Encoding encoding){
        this.content = content;
        this.coding = encoding;
    }
    public enum Encoding{
        UTF8("UTF-8"),
        UTF16("UTF-16"),
        UTF32("UTF-32");

        private final String code;
        private Encoding(String code){
            this.code = code;
        }
        public String getCode(){
            return code;
        }
    }
    public int size(){
        if(this.coding.equals(Encoding.UTF8)){
            return 41;
        } else if (this.coding.equals(Encoding.UTF32)) {
            return 300;
        } else if (this.coding.equals(Encoding.UTF16)) {
            return 164;
        }
        return 0;
    }
}
