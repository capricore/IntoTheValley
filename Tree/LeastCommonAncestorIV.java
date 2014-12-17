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
		//ʹ�ö��м�¼��������·��
		Queue<norTreeNode> pp = new LinkedList<norTreeNode>();
		Queue<norTreeNode> qq = new LinkedList<norTreeNode>();
		//ʹ�ù�ϣ����ÿ���ڵ�ĸ��ڵ�
		HashMap<norTreeNode, norTreeNode> backTracing  = new HashMap<norTreeNode, norTreeNode>();
		//ͨ���ǵݹ�ķ�ʽ��������ȱ���������
		while (!currentLevel.isEmpty()) {
			while (!currentLevel.isEmpty()) {
				nextLevel = new LinkedList<norTreeNode>();
				norTreeNode node = currentLevel.poll();
				for (norTreeNode child : node.children) {
					backTracing.put(child, node);
					if (child == p) {
						addParent(pp,p,backTracing);//���p��������·����������pp��
					}else if (child == q) {
						addParent(qq,q,backTracing);//���q��������·����������qq��
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
			//���ݶ�ȡ��ϣ��
			que.add(parentNode);
			parentNode = bt.get(parentNode);
		}
	}
	
	norTreeNode getLCA(Queue<norTreeNode> pp, Queue<norTreeNode> qq)
	{
		norTreeNode resultNode  = null;
		while (!pp.isEmpty() && !qq.isEmpty()) {//��������ʼ�Ƚ�
			norTreeNode pParent  = pp.poll();
			norTreeNode qParent  = qq.poll();
			if (pParent == qParent) {
				resultNode = pParent;//��¼ÿ����ͬ��ֵ����Ϊ��ǰ����С��������
			}else {
				break;
			}
		}
		return resultNode;
	}
}
