package src.service;

import src.interfaces.InvestimentInterface;

public class SavingsService implements InvestimentInterface {
    @Override
    public Double investimento(double investimento) {
        return investimento * 0.05;
    }
}
