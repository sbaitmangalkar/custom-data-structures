package com.custom.datastructures.blockchain;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.custom.datastructures.blockchain.Block;
import com.custom.datastructures.blockchain.BlockChain;

/**
 * Test class for <code>BlockChain</code>
 * Add your own <code>Assert</code> statements to test.
 * 
 * @author Shyam Baitmangalkar | catch.shyambaitmangalkar@gmail.com
 *
 */
public class BlockChainTest {
	private BlockChain<String> blockChain;
	
	@Before
	public void init() {
		blockChain = new BlockChain<>();
		
	}
	
	@Test
	public void test() {
		blockChain.add("Shyam gave 10 bitcoins to Krithi");
		blockChain.add("Krithi gave 2 bitcoins to Shyam");
		
		for(Block<?> b : blockChain.getAllBlocks()) {
			System.out.println(b.hash);
		}
		Assert.assertEquals(2, blockChain.size());
	}
	
	@After
	public void tearDown() {
		if(blockChain != null)
			blockChain = null;
	}
}
