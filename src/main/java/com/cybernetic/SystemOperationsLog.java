package com.cybernetic;

import java.util.ArrayList;
import java.util.List;

public class SystemOperationsLog {

    private SystemOperation[] stack;
    private int top;

    public SystemOperationsLog(int size) {
        stack = new SystemOperation[size];
        top = -1;
    }

    public void pushOperation(SystemOperation operation) {
        if (top >= stack.length - 1) {
            System.out.println("Stack overflow. Cannot push more operations.");
            return;
        }
        stack[++top] = operation;
    }

    public SystemOperation popLastOperation() {
        if (top < 0) {
            System.out.println("Stack underflow. No operations to pop.");
            return null;
        }
        return stack[top--];
    }

    public SystemOperation peekLastOperation() {
        if (top < 0) {
            System.out.println("Stack is empty.");
            return null;
        }
        return stack[top];
    }

    public void undoLastOperation() {
        if (top < 0) {
            System.out.println("No operations to undo.");
            return;
        }
        SystemOperation lastOperation = stack[top];
        if (!lastOperation.isReversible) {
            System.out.println("Operation " + lastOperation.operationId + " is not reversible.");
        } else {
            System.out.println("Undoing operation: " + lastOperation.operationId);
            popLastOperation();
        }
    }

    public List<SystemOperation> getRecentOperations(int count) {
        List<SystemOperation> recentOps = new ArrayList<>();
        for (int i = top; i >= 0 && count > 0; i--, count--) {
            recentOps.add(stack[i]);
        }
        return recentOps;
    }
}
