class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        int idxA = a-1;
        int idxB = b-1;
        while(idxA/2 != idxB/2) {
            idxA = idxA/2;
            idxB = idxB/2;
            answer++;
        }

        return answer;
    }
}