class PriorityQueue(object):
    'bisic implement of priority queue'
    def __init__(self, array):
        """
        :param array:
        index 0 is not used
        """
        self.array = array
        self.N     = len(array) - 1

    def swim(self, k):
        while (k>1) and (self.array[k/2]<self.array[k]):
            self.array[k/2], self.array[k] = self.array[k], self.array[k/2]
            k                              = k / 2

    def sink(self, k):
        while (2*k<=self.N):
            j = 2 * k
            if (j<self.N) and (self.array[j]<self.array[j+1]):
                j += 1
            if self.array[k]>=self.array[j]:
                break
            self.array[k], self.array[j] = self.array[j], self.array[k]
            k = j

    def createQueue(self):
        N = len(self.array) - 1
        k = N / 2
        while k>=1:
            self.sink(k)
            k -= 1

    def sortValue(self):
        while self.N>1:
            self.array[1], self.array[self.N] = self.array[self.N], self.array[1]
            self.N       -= 1
            self.sink(1)

    def printOut(self):
        for i in range(1, len(self.array)):
            print self.array[i]




