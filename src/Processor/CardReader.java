package Processor;

import InputOutput.InputOutput;
import database.StaticDB;

import java.io.IOException;
import java.util.ArrayList;

public class CardReader {

    InputOutput file = new InputOutput();
    StaticDB staticDb = StaticDB.getInstance();

    public void addCardToDB(String path) throws IOException {
        this.file.readInputCsv(path);
        storeCardInDB();
    }

    private void storeCardInDB() {
        ArrayList<String> fileData = new ArrayList<>();
        fileData = this.file.getFileData();

        for (int i = 0; i < fileData.size(); i++) {
            String card = fileData.get(i);
            staticDb.getCards().add(card);
        }

    }}
