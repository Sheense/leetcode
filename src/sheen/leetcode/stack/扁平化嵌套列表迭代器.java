package sheen.leetcode.stack;

import java.util.*;

public class 扁平化嵌套列表迭代器 {

    public static void main(String[] args) {
        List<NestedInteger> list = Arrays.asList(new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                return Arrays.asList(new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return -1;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                });
            }
        }, new NestedInteger() {
            @Override
            public boolean isInteger() {
                return false;
            }

            @Override
            public Integer getInteger() {
                return null;
            }

            @Override
            public List<NestedInteger> getList() {
                return Arrays.asList(new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return false;
                    }

                    @Override
                    public Integer getInteger() {
                        return null;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return Arrays.asList(new NestedInteger() {
                            @Override
                            public boolean isInteger() {
                                return true;
                            }

                            @Override
                            public Integer getInteger() {
                                return -1;
                            }

                            @Override
                            public List<NestedInteger> getList() {
                                return null;
                            }
                        });
                    }
                });
            }
        });
        NestedIterator s = new NestedIterator(list);
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }

    public static NestedInteger get(int... arg) {
        if(arg.length==1) {
            return new NestedInteger() {
                @Override
                public boolean isInteger() {
                    return true;
                }

                @Override
                public Integer getInteger() {
                    return arg[0];
                }

                @Override
                public List<NestedInteger> getList() {
                    return null;
                }
            };
        }else {
            List<NestedInteger> list = new ArrayList<>();
            for(int i=0;i<arg.length;i++) {
                list.add(get(arg[i]));
            }
            return new NestedInteger() {
                @Override
                public boolean isInteger() {
                    return false;
                }

                @Override
                public Integer getInteger() {
                    return null;
                }

                @Override
                public List<NestedInteger> getList() {
                    return list;
                }
            };
        }
    }

    public static class NestedIterator implements Iterator<Integer> {

        private Stack<List<NestedInteger>> stack;
        private Stack<Integer> index;
        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            index = new Stack<>();
            stack.push(nestedList);
            index.push(0);
        }

        @Override
        public Integer next() {
            int res = stack.peek().get(index.peek()).getInteger();
            index.push(index.pop()+1);
            return res;
        }

        @Override
        public boolean hasNext() {
            if(stack.size()==1&&stack.peek().size()<=index.peek()) return false;
            List<NestedInteger> list = stack.peek();
            int i = index.peek();
            if (i<list.size()&&list.get(i).isInteger()){
                return true;
            }else if(i>=list.size()){
                do{
                    stack.pop();
                    index.pop();
                    if(!stack.isEmpty()&&stack.peek().size()>index.peek()) {
                        if(stack.peek().get(index.peek()).isInteger()) return true;
                        else {
                            while(stack.peek().size()>index.peek()&&!stack.peek().get(index.peek()).isInteger()){
                                stack.push(stack.peek().get(index.peek()).getList());
                                index.push(index.pop()+1);
                                index.push(0);
                            }
                        }
                    }
                }while (!stack.isEmpty()&&stack.peek().size()<=index.peek());
                if(stack.isEmpty()) return false;
                return true;
            }else {
               do {
                   List<NestedInteger> N = stack.peek().get(index.peek()).getList();
                   stack.push(N);
                   index.push(index.pop()+1);
                   index.push(0);
                   if(stack.peek().size()>index.peek()) {
                        if(stack.peek().get(index.peek()).isInteger()) return true;
                    }else {
                        while(!stack.isEmpty()&&stack.peek().size()<=index.peek()) {
                            stack.pop();
                            index.pop();
                        }
                    }
                } while(!stack.isEmpty()&&!stack.peek().get(index.peek()).isInteger());
                if(stack.isEmpty()) return false;
                return true;
            }
        }
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();
        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();
        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
  }
}
