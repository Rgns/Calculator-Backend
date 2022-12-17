package com.project.rg.Calculator.services;

import com.project.rg.Calculator.common.Constants;
import com.project.rg.Calculator.dao.HistoryRepository;
import com.project.rg.Calculator.model.CalcRequest;
import com.project.rg.Calculator.model.CalculatedResult;
import com.project.rg.Calculator.model.History;
import com.project.rg.Calculator.model.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.project.rg.Calculator.common.Constants.CalcConstants.*;

@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;


    @Autowired
    AuthService authService;

    public void createCalculateHistory(CalcRequest request, CalculatedResult result){
        String createdString = createHistoryString(request.getInput1().getData(), request.getOperator(), request.getInput2().getData(),  result.getResult());
        History history = new History(authService.getCurrentLoggedInUser(),createdString, new Date());
        historyRepository.save(history);
    }

    private String createHistoryString(String  input1, Operator  operator, String  input2, String  result  ){

        return input1 + SPACE  + getSymbolForOperator(operator) +SPACE+ input2 + SPACE + EQUAL_TO + SPACE + result;

    }



    private String getSymbolForOperator(Operator operator){
        switch (operator){
            case MULTIPLY:
                return MUL;
            case DIVIDE:
                return DIV;
            case MINUS:
                return SUB;
            case ADD:
                return ADD;
        }
        return null;
    }
}
