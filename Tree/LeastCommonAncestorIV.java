package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class norTreeNode{
	int val;
	ArrayList<norTreeNode> children;
}

public class LeastCommonAncestorIV {
	norTreeNode LCA4(norTreeNode root, norTreeNode p, norTreeNode q)
	{
		if (root == null || p == null || q == null) {
			return null;
		}
		Queue<norTreeNode> currentLevel = new LinkedList<norTreeNode>();
		Queue<norTreeNode> nextLevel = new LinkedList<norTreeNode>();
		currentLevel.offer(root);
		//使用队列记录到树根的路径
		Queue<norTreeNode> pp = new LinkedList<norTreeNode>();
		Queue<norTreeNode> qq = new LinkedList<norTreeNode>();
		//使用哈希表保存每个节点的父节点
		HashMap<norTreeNode, norTreeNode> backTracing  = new HashMap<norTreeNode, norTreeNode>();
		//通过非递归的方式，广度优先遍历整棵树
		while (!currentLevel.isEmpty()) {
			while (!currentLevel.isEmpty()) {
				nextLevel = new LinkedList<norTreeNode>();
				norTreeNode node = currentLevel.poll();
				for (norTreeNode child : node.children) {
					backTracing.put(child, node);
					if (child == p) {
						addParent(pp,p,backTracing);//求出p到树根的路径，保存在pp中
					}else if (child == q) {
						addParent(qq,q,backTracing);//求出q到树根的路径，保存在qq中
					}
					if (!pp.isEmpty() && !qq.isEmpty()) {
						return getLCA(pp,qq);
					}else
					{
						nextLevel.offer(child);
					}
				}
			}
			currentLevel = nextLevel;
		}
		return null;
	}
	
	
	void addParent(Queue<norTreeNode> que, norTreeNode q, HashMap<norTreeNode, norTreeNode> bt)
	{
		norTreeNode parentNode = bt.get(q);
		while (parentNode != null) {
			//回溯读取哈希表
			que.add(parentNode);
			parentNode = bt.get(parentNode);
		}
	}
	
	norTreeNode getLCA(Queue<norTreeNode> pp, Queue<norTreeNode> qq)
	{
		norTreeNode resultNode  = null;
		while (!pp.isEmpty() && !qq.isEmpty()) {//从树根开始比较
			norTreeNode pParent  = pp.poll();
			norTreeNode qParent  = qq.poll();
			if (pParent == qParent) {
				resultNode = pParent;//记录每次相同的值，即为当前的最小公共祖先
			}else {
				break;
			}
		}
		return resultNode;
	}
}
