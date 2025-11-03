package src.service;

import src.interfaces.InvestimentInterface;

public class CDBService implements InvestimentInterface {
    @Override
    public Double investimento(double investimento) {
        return investimento * 0.22;
    }
}
