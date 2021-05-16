package com.cloud.datastructyres.linkedlist;

/**
 * 单链表
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
//        LinkedList linkedList = new LinkedList();
//        linkedList.add(heroNode1);
//        linkedList.add(heroNode4);
//        linkedList.add(heroNode3);
//        linkedList.add(heroNode2);
//        linkedList.list();
        System.out.println("-------------------------------------------------------------");
        LinkedList linkedList1 = new LinkedList();
        linkedList1.addByOrder(heroNode1);
        linkedList1.addByOrder(heroNode4);
        linkedList1.addByOrder(heroNode3);
        linkedList1.addByOrder(heroNode2);
        linkedList1.list();
        System.out.println("-------------------------------------------------------------");
        linkedList1.update(new HeroNode(4, "林冲11", "豹子头11"));
        linkedList1.list();
        System.out.println("-------------------------------------------------------------");
        linkedList1.del(4);
        linkedList1.list();
    }
}

/**
 * 定义管理链表
 */
class LinkedList {
    // 定义一个头结点
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 固定顺序添加数据
     *
     * @param heroNode 节点
     */
    public void add(HeroNode heroNode) {
        // 声明一个临时变量表示指针
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            // 找到变量
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            // 指针后移
            temp = temp.next;
        }
    }

    /**
     * 按顺序添加数据
     *
     * @param heroNode 节点
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            } else if (temp.next.no == heroNode.no) {
                System.out.println("已经存在了！");
                break;
            } else if (temp.next.no > heroNode.no) {
                heroNode.next = temp.next;
                temp.next = heroNode;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 修改节点信息
     *
     * @param heroNode 节点
     */
    public void update(HeroNode heroNode) {
        if (head.next == null) {
            System.out.println("链表为空！");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            } else if (temp.no == heroNode.no) {
                temp.name = heroNode.name;
                temp.nickname = heroNode.nickname;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 删除节点
     *
     * @param no no
     */
    public void del(int no) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            } else if (temp.next.no == no) {
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 显示链表
     */
    public void list() {
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            } else {
                System.out.println(temp);
                temp = temp.next;
            }
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; // 指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
