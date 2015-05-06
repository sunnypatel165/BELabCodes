.model small
.data
p db 0ffh
q db 0ffh
mult dw ?
.code
start:
mov ax,@data
mov ds,ax
mov al,p
mul q
mov mult,ax
end start	