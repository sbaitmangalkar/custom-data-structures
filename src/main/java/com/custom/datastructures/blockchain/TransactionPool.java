package com.custom.datastructures.blockchain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransactionPool<Transaction> {
	private List<Transaction> pool;
	
	public TransactionPool() {
		pool = new ArrayList<>();
	}

	public List<Transaction> getPool() {
		return pool;
	}
	
	public void addTransaction(Transaction transaction) {
		Random rand = new Random();
		int index = rand.nextInt(pool.size() - 1);
		pool.add(index, transaction);
	}
}
