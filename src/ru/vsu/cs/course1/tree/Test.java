package ru.vsu.cs.course1.tree;

public class Test {
    public static int getMinLeftSonValue(DefaultBinaryTree<Integer> binaryTree) {
        // получаем корень дерева
        DefaultBinaryTree.TreeNode<Integer> root = binaryTree.getRoot();
        // если он не пустой, то у него есть листья (возможно пустые)
        if (root != null) {
            // вызываем рекурсию для поиска значения
            return getMinLeftSonValue(root, -1);
        }
        // если же корень пустой, то в дереве нет левых потомков, возвращаем -1
        return -1;
    }

    private static int getMinLeftSonValue(DefaultBinaryTree.TreeNode<Integer> node, int minValue) {
        int currentMinValue = minValue;

        // если текущий узел не пустой, значит у него есть значения и возможно есть потомки
        if (node != null) {
            // получаем левого потомка
            DefaultBinaryTree.TreeNode<Integer> leftNode = node.getLeft();
            // если левый потомок не пустой
            if (leftNode != null) {
                // то сравниваем его значением с минимальным найденным значением

                if (minValue == -1 || leftNode.getValue() < currentMinValue) {
                    // если ещё не находили минимальное значение (= -1)
                    // если значение узла меньше минимального, то теперь он минимальный
                    currentMinValue = leftNode.getValue();
                }
                // вызываем рекурсию для левого узла
                currentMinValue = getMinLeftSonValue(node.getLeft(), currentMinValue);
            }
            // получаем правого потомка
            DefaultBinaryTree.TreeNode<Integer> rightNode = node.getRight();
            // если он не пустой
            if (rightNode != null) {
                // его значение с минимумом не сравниваем, т.к. это ПРАВЫЙ потомок

                // вызываем рекурсию для правого узла
                currentMinValue = getMinLeftSonValue(node.getRight(), currentMinValue);
            }
        }
        // возвращаем результат
        return currentMinValue;
    }
}