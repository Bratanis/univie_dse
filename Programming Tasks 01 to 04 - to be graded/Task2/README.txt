## Diclaimer:
This part of the task (TCP sockets) contains my implementation from the previous semester (SS24). 
V1-V3 were copied with little to no changes, while V4 was only partially copied. 
The UDP part is completely new, although I have referecned by TCP implementation while writing it.

## Result example in v4:
Messaage with a blob of size:1024B have an average roundtrip transmission time of:352ms.
Messaage with a blob of size:2048B have an average roundtrip transmission time of:348ms.
Messaage with a blob of size:4096B have an average roundtrip transmission time of:348ms.
Messaage with a blob of size:8192B have an average roundtrip transmission time of:352ms.
Messaage with a blob of size:16384B have an average roundtrip transmission time of:349ms.
Messaage with a blob of size:131072B have an average roundtrip transmission time of:185ms.

## Analysis of results
When transmitting different blob sizes in a multi-threaded fashion I have noticed the folloiwng:
- The blob sizes between 1, 2, 4, 8, 16 KiB don't seem to make much of a difference for performance.
  It takes approximately the same time to transfer the messge
- The blob size of 128 KiB seems to get transfered noticalby quicker than the others, which is counter intuitive.
  My theory is that the bigger data packets are considered more important by the system and are given priority 
  over the smaller packets.

## TCP specifics:

## UDP specifics:

