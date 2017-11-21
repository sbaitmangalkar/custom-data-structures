package com.custom.datastructures.blockchain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <code>BlockChain</code> is the underlying data structure to support
 * the transactions of cryptocurrencies and digital signatures.
 * 
 * This is a basic implementation of a <code>BlockChain</code> which is
 * a reverse <code>LinkedList</code> with each <code>Block</code> holding
 * the information of it's previous <code>Block</code>
 * 
 * This implementation takes in a generic argument. But in real world, that
 * might not be the case. <code>BlockChain</code> might use a proper 
 * <code>Transaction</code> object which would be much more complex in nature.
 * 
 * @author Shyam Baitmangalkar | catch.shyambaitmangalkar@gmail.com
 *
 * @param <Transaction>
 */
public class BlockChain<Transaction> implements Iterable<Transaction> {
	private Block<Transaction> first;
	private int size;
	
	public BlockChain() {
		first = null;
		size = 0;
	}
	
	/**
	 * Adds a given <code>Transaction</code> to the <code>BlockChain</code>
	 * 
	 * @param transaction
	 */
	public void add(Transaction transaction) {
		Block<Transaction> oldFirst = first;
		first = new Block<>(transaction);
		first.previous = oldFirst;
		size++;
	}
	
	/**
	 * Returns the first <code>Transaction</code>
	 * @return
	 */
	public Transaction get() {
		if(isEmpty())
			throw new UnsupportedOperationException("Oops!! BlockChain is Empty!!");
		return first.transaction;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return first == null;
	}
	
	/**
	 * 
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Returns all <code>Block</code> that build up
	 * the chain.
	 * 
	 * @return
	 */
	public List<Block<Transaction>> getAllBlocks() {
		List<Block<Transaction>> blocks = new ArrayList<>();
		Block<Transaction> current = first;
		while(current.previous != null) {
			blocks.add(current);
			current = current.previous;
		}
		blocks.add(current);
		return blocks;
	}

	@Override
	public Iterator<Transaction> iterator() {
		return new BlockChainIterator<>(first);
	}

	@Override
	public String toString() {
		return "BlockChain [first=" + first + ", size=" + size + "]";
	}

}
