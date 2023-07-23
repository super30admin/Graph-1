/*
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
*/

#include<iostream>
#include<vector>
#include<unordered_map>
#include<queue>

using namespace std;

class Gg{
    
    public:
    int _x;
    int _y;
    Gg(){
        _x = 0;
        _y = 0;
    }
    Gg(int x,int y){
        _x = x;
        _y = y;
    }
    
    bool operator==(Gg node){
        if(this->_x == node._x && this->_y == node._y) return true;
        return false;
    }
};

class Solution{
    
    public:
    
    void hasPath(vector<vector<int>>& matrix,vector<int> start,vector<int> dest){
        vector<Gg> dirs{
            Gg(-1,0),
            Gg(1,0),
            Gg(0,1),
            Gg(0,-1)
        };
        queue<Gg> que;
        Gg gg_start = Gg(start.at(0),start.at(1));
        que.push(Gg(start.at(0),start.at(1)));
        Gg gg_dest = Gg(dest.at(0),dest.at(1));
        
        if(gg_dest == gg_start) return;
        matrix.at(gg_start._x).at(gg_start._y) = -1;
        int m = matrix.size();
        int n = matrix.at(0).size();
        while(!que.empty()){
            int sz = que.size();
            cout<<"size is"<<sz<<endl;
            for(int i{};i<sz;++i){
                Gg node = que.front();
                que.pop();
                for(Gg& dir:dirs){
                    int x = node._x + dir._x;
                    int y = node._y + dir._y;
                    while(x>=0 && x<m && y>=0 && y<n && matrix.at(x).at(y)!=1){
                        x = x + dir._x;
                        y = y + dir._y;
                    }
                    x = x - dir._x;
                    y = y - dir._y;
                    if(Gg(x,y) == gg_dest){
                        cout<<"found";
                        return;
                    }
                    else if(matrix.at(x).at(y) == 0){
                        cout<<"x_val "<<x<<"y_val "<<y<<endl;
                        matrix.at(x).at(y) = -1;
                        que.push(Gg(x,y));
                    }
                }
            }
            
        }
        cout<<"not found"<<endl;
        return;
    }
};

int main(){
    vector<vector<int>> mat{
        {0,0,1,0,0},
        {0,0,0,0,0},
        {0,0,0,1,0},
        {1,1,0,1,1},
        {0,0,0,0,0}
    };
    vector<int> start{0,4};
    vector<int> dest{4,4};
    Solution sol;
    
    sol.hasPath(mat,start,dest);

    cout<<endl;

    vector<int> start_2{0,4};
    vector<int> dest_2{3,2};

    sol.hasPath(mat,start_2,dest_2);

}