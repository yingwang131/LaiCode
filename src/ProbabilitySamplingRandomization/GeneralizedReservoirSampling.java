package ProbabilitySamplingRandomization;

import java.util.ArrayList;
import java.util.List;
//这个题目是找出随机等概率的 k 个元素
//int count 物理意义：当前读进来了哪些数字的个数
public class GeneralizedReservoirSampling {
    private final int k;
    private int count;
    private List<Integer> sample;

    public GeneralizedReservoirSampling(int k){
        //we need to sample k elements instead of just one element,usually we will need this validation in the constructor
        if (k <= 0){
            throw new IllegalArgumentException("K must be > 0");
        }

        this.k = k;
        this.count = 0;
        sample = new ArrayList<>();

    }
    public void read(int value){
        count++;
        //for the first k elements, we just need to add them into the sample
        if (count <= k){
            sample.add(value);
        }else{
            int random = (int) (Math.random()*count);
            // 以 k/count 保留newElement
            if (random < k){
                // replace the sample at the corresponding position
                sample.set(random, value);
            }
        }
    }
    public List<Integer> sample(){
        return sample;
    }
}
