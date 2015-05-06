.model small
.data
arr db 0,1,3,2,6,7,5,4,12,13,15,14,10,11,9,8
convert db 15
converted db ?
.code
start:
mov ax,@data
mov ds,ax
lea bx,arr
mov al,convert
xlat
mov converted,al
mov ah,4ch
int 21h
end start
