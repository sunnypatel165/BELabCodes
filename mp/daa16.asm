.model small
.data
x dw 2579h
y dw 3988h
res dw ?
car db ?
.code
start:
mov ax,@data
mov ds,ax
mov ax,x
mov bx,y
add al,bl
daa
mov cl,al
mov al,ah
mov bl,bh
adc al,bl
daa
mov ch,al
mov res,cx
mov al,00
adc al,00
mov car,al
mov ah,4ch
int 21h
end start