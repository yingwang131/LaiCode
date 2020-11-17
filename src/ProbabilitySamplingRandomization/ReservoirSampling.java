package ProbabilitySamplingRandomization;
// 这个题目是找出一个sample from the flow
//int count 物理意义：当前读进来了哪些数字的个数
public class ReservoirSampling {
    //this class will be used as a reader and it read each of the element by calling the read()method
    //by calling the sample()method, it will return the sample of whatever read before

    //how many numbers have been read so far
    private int count;
    //only need to maintain the current sample
    private Integer sample;

    //this is my constructor
    public ReservoirSampling() {
        //initialization, count as 0 since there is no single number read at the beginning
        this.count = 0;
        this.sample = null;
    }
    public void read(int value){
        count++;
        //the current read value has the probability of 1/count to be as the current sample
        // 如果sample： 5，3； 那么generate 第一个sample 一定是 5， 5的概率为0；
        // 那么generate 第二个sample 不一定是谁，但是random generate 的概率是：5（1/2), 3（1/2）
        int prob = (int) (Math.random()* count);
        if (prob == 0){
            sample = value;
        }
    }
    public Integer sample(){
        return sample;
    }

    public static void main(String[] args) {
        ReservoirSampling sol = new ReservoirSampling();
        int value = 5;
        sol.read(value);
    }
}
