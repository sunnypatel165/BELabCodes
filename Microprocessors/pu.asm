.model small
.data
packed db 12h
unpacked dw ?
.code
start:
mov ax,@data
mov ds,ax

mov ax,0000
mov al,packed

and al,00fh
mov bl,al

mov ax,0000
mov ah,packed
and ah,0f0h
mov cl,04h
ror ah,cl
mov bh,ah

mov unpacked,bx

mov ah,4ch
int 21h
end start
