package com.custom.datastructures.blockchain;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BlockChainIterator<Transaction> implements Iterator<Transaction> {
	private Block<Transaction> current;
	
	public BlockChainIterator(Block<Transaction> first) {
		this.current = first;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public Transaction next() {
		if(! hasNext())
			throw new NoSuchElementException("Oops!! No such element in BlockChain");
		Transaction transaction = current.transaction;
		current = current.previous;
		return transaction;
	}

}
