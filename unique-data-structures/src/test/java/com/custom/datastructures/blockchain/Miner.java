package com.custom.datastructures.blockchain;

/**
 * Miners are the people who add transactions to public ledger
 * 
 * @author Shyam | catch.shyambaitmangalkar@gmail.com
 *
 */
public class Miner {
	private String id;
	private BlockChain<?> blockChain;
	
	public Miner(String id, BlockChain<?> blockChain) {
		this.id = id;
		this.blockChain = blockChain;
	}

	public BlockChain<?> getBlockChain() {
		return blockChain;
	}

	@Override
	public String toString() {
		return "Miner [id=" + id + ", blockChain=" + blockChain + "]";
	}
}
