# Channel and Go Routines
Goroutines are called Threads in Java, in Golang, one Goroutine communicates with another through channels, in this algorithm, we are implementing our own Goroutine and our Channel, using Java, of course our code is more complex and robust compared to simplicity of Golang, but I created a simple prototype because of my proximity to the Java language.

## Code details
We are implementing the code below in Java:

``` golang
package main

import (
	"fmt"
	"time"
)

func worker(workerId int, data chan int) {
	for x := range data {
		fmt.Printf("Worker %d received %d\n", workerId, x)
		time.Sleep(time.Second)
	}
}

func main() {
	channel := make(chan int)
	for i := 0; i < 1000; i++ {
		go worker(i, channel)
	}
	for i := 0; i < 100000; i++ {
		channel <- i
	}
}
```
