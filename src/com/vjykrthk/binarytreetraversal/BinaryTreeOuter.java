package com.vjykrthk.binarytreetraversal;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

public class BinaryTreeOuter {
	static Node rootNode;
	Context context;
	static Resources res;
	static Node currentNode;
	public static String tag = "BTO";

	public BinaryTreeOuter(Context context) {
		this.context = context;
		res = context.getResources();
		int rootValue = Integer.parseInt(res.getString(R.string.rootvalue));
		rootNode = new Node(rootValue);
		currentNode = rootNode;
		int[] nodeValues = res.getIntArray(R.array.nodevalues);
		for (int i = 0; i < nodeValues.length; i++) {
			rootNode.insert(rootNode, nodeValues[i]);
		}
	}

	public static void main() {

	}

	static class Node {
		Node leftNode;
		Node rightNode;
		private int value;

		public Node(int value) {
			this.value = value;
		}

		public int nodeValue() {
			return this.value;
		}

		public void insert(Node node, int value) {
			if (value < node.nodeValue()) {
				Log.d(tag, "Left : " + value);
				if (node.leftNode != null) {
					insert(node.leftNode, value);
				} else {
					node.leftNode = new Node(value);
				}
			} else {
				Log.d(tag, "Right : " + value);
				if (node.rightNode != null) {
					insert(node.rightNode, value);
				} else {
					node.rightNode = new Node(value);
				}
			}
		}

		public static Node traverse(Long targetValue) {
			Log.d(tag, "targetValue : " + targetValue + "currentNodeValue : "
					+ currentNode.nodeValue());
			if (currentNode.nodeValue() > targetValue) {
				if (currentNode.leftNode != null) {
					currentNode = currentNode.leftNode;
					return currentNode;
				} else {
					Log.d(tag, "LeftNode value is null");					
					return null;
				}
			} else {
				if (currentNode.rightNode != null) {
					Log.d(tag,
							"RightNode value "
									+ currentNode.rightNode.nodeValue());
					currentNode = currentNode.rightNode;
					return currentNode;
				} else {
					Log.d(tag, "RightNode value is null");
					return null;
				}
			}

		}
	}
}
