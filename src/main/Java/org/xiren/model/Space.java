package org.xiren.model;
/**
 * @author xiren
 * @version 1.0
 * @date 2020/10/27 14:07
 */
public class Space {
    private long freeSpace;
    private long UsableSpace;

    public Space() {
    }

    public Space(long freeSpace, long usableSpace) {
        this.freeSpace = freeSpace;
        UsableSpace = usableSpace;
    }

    public long getFreeSpace() {
        return freeSpace;
    }

    public void setFreeSpace(long freeSpace) {
        this.freeSpace = freeSpace;
    }

    public long getUsableSpace() {
        return UsableSpace;
    }

    public void setUsableSpace(long usableSpace) {
        UsableSpace = usableSpace;
    }

    @Override
    public String toString() {
        return "Space{" +
                "freeSpace=" + freeSpace +
                ", UsableSpace=" + UsableSpace +
                '}';
    }
}
