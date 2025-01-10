package org.hbrs.se1.ws24.exercises.uebung9;

import java.util.ArrayList;
import java.util.List;

public class ComplexDocument extends AbstractDocument{
    private List<Document> docList = new ArrayList<>();
    public void addDocument(Document doc){
        this.docList.add(doc);
    }
    public void removeDocument(Document doc){
        this.docList.remove(doc);
    }
    @Override
    public int size(){
        int gesamtByte = 0;
        for (Document doc : docList){
            gesamtByte = gesamtByte + doc.size();
        }
        return gesamtByte;
    }

}
