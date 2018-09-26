package com.gmail.lev.romanenko.data;

import com.gmail.lev.romanenko.data.line.lines.CLine;
import com.gmail.lev.romanenko.data.line.lines.DLine;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Data {

    private int lineCount;
    private Map<DLine, List<CLine>> DAndCLines;

    public Data(int lineCount, Map<DLine, List<CLine>> DAndCLines) {
        this.lineCount = lineCount;
        this.DAndCLines = DAndCLines;
    }

    public Data() {
    }

    public int getLineCount() {
        return lineCount;
    }

    public void setLineCount(int lineCount) {
        this.lineCount = lineCount;
    }

    public Map<DLine, List<CLine>> getDAndCLines() {
        return DAndCLines;
    }

    public void setDAndCLines(Map<DLine, List<CLine>> DAndCLines) {
        this.DAndCLines = DAndCLines;
    }


}
