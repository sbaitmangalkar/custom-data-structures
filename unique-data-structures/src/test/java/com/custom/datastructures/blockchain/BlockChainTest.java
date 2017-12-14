package com.custom.datastructures.blockchain;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.custom.datastructures.blockchain.BlockChain.Block;


/**
 * Test class for <code>BlockChain</code>
 * Add your own <code>Assert</code> statements to test.
 * 
 * @author Shyam Baitmangalkar | catch.shyambaitmangalkar@gmail.com
 *
 */
public class BlockChainTest {
	private BlockChain<String> blockChain;
	private List<Miner> miners;
	
	@Before
	public void init() {
		blockChain = new BlockChain<>();
		miners = new ArrayList<>();
		
		Miner satoshi = new Miner("192.168.0.1", blockChain);
		Miner mark = new Miner("192.168.1.1", blockChain);
		
		miners.add(mark);
		miners.add(satoshi);
	}
	
	@Test
	public void test() {
		Miner mark = miners.get(0);
		Miner satoshi = miners.get(1);
		
		BlockChain<String> marksblockChain = (BlockChain<String>) mark.getBlockChain();
		BlockChain<String> satoshisBlockChain = (BlockChain<String>) satoshi.getBlockChain();
		//Mark adds a transaction
		marksblockChain.add("Shyam gave 10 bitcoins to Heisenberg");
		
		//Satoshi adds a transaction
		satoshisBlockChain.add("Heisenberg gave 20 bitcoins to Jessi");
		
		for(Block<?> block : blockChain.getAllBlocks()) {
			System.out.println(block);
			System.out.println(block.hash);
		}
		
		System.out.println(marksblockChain);
		System.out.println(satoshisBlockChain);
		Assert.assertEquals(2, blockChain.size());
	}
	
	@After
	public void tearDown() {
		if(blockChain != null)
			blockChain = null;
	}
}
