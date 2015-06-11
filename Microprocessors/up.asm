.model small
.data
unpacked dw 0507h
packed db ?
.code
start:
mov ax,@data
mov ds,ax

mov ax,0000h
mov ax,unpacked

mov cl,04
rol ah,cl
mov bh,ah
add bh,al
mov packed,bh

mov ah,4ch
int 21h
end start