package org.psnbtech;

import java.awt.Point;
import java.util.ArrayList;

public class Node{
	private Point point;
	private Node parent;
	private float g , h, f = 0;

	public float getG() {
		return g;
	}

	public void setG(float g) {
		this.g = g;
	}

	public float getH() {
		return h;
	}

	public void setH(float h) {
		this.h = h;
	}

	public float getF() {
		return f;
	}

	public void setF(float f) {
		this.f = f;
	}

	public Node(){}
	
	public Node(Point p){ point = p;}
	
	/*Example
	 * 010
	 * 1x1
	 * 010
	 */
	public ArrayList<Node> getNeighbors(BoardPanel board){
		ArrayList<Node> list = new ArrayList<Node>();
		Point p = new Point(point.x, point.y - 1);
		if(p.y > 0 && board.getTile(p.x, p.y) != TileType.SnakeBody){
				Node node = new Node(p);
				list.add(node);
			}
		p = new Point(point.x, point.y + 1);
		if(p.y < board.ROW_COUNT && board.getTile(p.x, p.y) != TileType.SnakeBody){
			Node node = new Node(p);
			list.add(node);
			}
		p = new Point(point.x - 1, point.y);
		if(p.x > 0 && board.getTile(p.x, p.y) != TileType.SnakeBody){
			Node node = new Node(p);
			list.add(node);
		}
		p = new Point(point.x + 1, point.y);
		if(p.x < board.ROW_COUNT && board.getTile(p.x, p.y) != TileType.SnakeBody){
			Node node = new Node(p);
			list.add(node);
		}
		return list;
	}
	
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}
	
	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}
	
	// sort theo f
//	@Override
//	public int compareTo(Node o) {
//		// TODO Auto-generated method stub
//		return Float.compare(this.f, o.f);
//	}	
}
